package org.robolectric.shadows;

import android.app.JobSchedulerImpl;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static android.os.Build.VERSION_CODES.N;

@Implements(value = JobScheduler.class, minSdk = LOLLIPOP)
public abstract class ShadowJobScheduler {

  @Implementation
  protected abstract int schedule(JobInfo job);

  @Implementation
  protected abstract void cancel(int jobId);

  @Implementation
  protected abstract void cancelAll();

  @Implementation
  protected abstract List<JobInfo> getAllPendingJobs();

  @Implementation(minSdk = N)
  public abstract JobInfo getPendingJob(int jobId);

  public abstract void failOnJob(int jobId);

  @Implements(value = JobSchedulerImpl.class, isInAndroidSdk = false)
  public static class ShadowJobSchedulerImpl extends ShadowJobScheduler {

    private Map<Integer, JobInfo> scheduledJobs = new HashMap<>();
    private Set<Integer> jobsToFail = new HashSet<>();

    @Override @Implementation
    protected int schedule(JobInfo job) {
      if (jobsToFail.contains(job.getId())) {
        return JobScheduler.RESULT_FAILURE;
      }

      scheduledJobs.put(job.getId(), job);
      return JobScheduler.RESULT_SUCCESS;
    }

    @Override @Implementation
    protected void cancel(int jobId) {
      scheduledJobs.remove(jobId);
    }

    @Override @Implementation
    protected void cancelAll() {
      scheduledJobs.clear();
    }

    @Override @Implementation
    protected List<JobInfo> getAllPendingJobs() {
      return new ArrayList<>(scheduledJobs.values());
    }

    @Override @Implementation(minSdk = N)
    public JobInfo getPendingJob(int jobId) {
      return scheduledJobs.get(jobId);
    }

    @Override
    public void failOnJob(int jobId) {
      jobsToFail.add(jobId);
    }
  }
}
