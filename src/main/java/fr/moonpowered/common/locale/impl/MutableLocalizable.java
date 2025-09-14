package fr.moonpowered.common.locale.impl;

import java.util.Locale;

import fr.moonpowered.common.locale.Localizable;
import org.jetbrains.annotations.NotNull;

public interface MutableLocalizable extends Localizable {

    void setLocale(final @NotNull Locale locale);

}
