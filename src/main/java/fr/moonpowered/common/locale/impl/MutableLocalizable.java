package fr.moonpowered.common.locale.impl;

import fr.moonpowered.common.locale.Localizable;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

public interface MutableLocalizable extends Localizable {

  void setLocale(final @NotNull Locale locale);
}
