package fr.moonpowered.common.locale.impl;

import fr.kurai.dream.locale.Localizable;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public interface MutableLocalizable extends Localizable {

    void setLocale(final @NotNull Locale locale);

}
