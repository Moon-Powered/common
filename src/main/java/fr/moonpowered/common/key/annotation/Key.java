package fr.moonpowered.common.key.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Declares a String key associated with a type, field, or method.
 *
 * <p>Retention is {@link RetentionPolicy#RUNTIME} so that frameworks and utilities can
 * access the key via reflection at runtime.</p>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Key {

  /**
   * The associated key value.
   *
   * @return the key string
   */
  String value();
}
