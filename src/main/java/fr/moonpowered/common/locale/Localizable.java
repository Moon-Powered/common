package fr.moonpowered.common.locale;

import java.util.Locale;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface Localizable {

  @NotNull
  Locale getLocale();
}
