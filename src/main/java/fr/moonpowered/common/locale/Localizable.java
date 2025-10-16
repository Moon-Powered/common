package fr.moonpowered.common.locale;

import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/**
 * Marks a type as being associated with a {@link Locale}.
 *
 * <p>Useful for user preferences, internationalization (i18n), and formatting contexts.</p>
 */
@FunctionalInterface
public interface Localizable {

  /**
   * Returns the non-null locale associated with this instance.
   *
   * @return the locale; never null
   */
  @NotNull
  Locale getLocale();
}
