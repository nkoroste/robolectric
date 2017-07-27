package org.robolectric.annotation.processing.validator;

import java.util.Set;
import javax.lang.model.element.Modifier;
import javax.tools.Diagnostic.Kind;
import org.robolectric.annotation.processing.RobolectricModel;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

/**
 * Validator that checks usages of {@link org.robolectric.annotation.Implementation}.
 */
public class ImplementationValidator extends FoundOnImplementsValidator {
  public ImplementationValidator(RobolectricModel model, ProcessingEnvironment env) {
    super(model, env, "org.robolectric.annotation.Implementation");
  }

  @Override
  public Void visitExecutable(ExecutableElement elem, TypeElement parent) {
    Set<Modifier> modifiers = elem.getModifiers();
    if (modifiers.contains(Modifier.PRIVATE)
        || modifiers.contains(Modifier.PUBLIC)
        || !modifiers.contains(Modifier.PROTECTED)) {
      message(Kind.WARNING, "@Implementation methods should be protected");
    }

    // TODO: Check that it has the right signature
    return null;
  }
}
