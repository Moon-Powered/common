package fr.moonpowered.common.locale;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

@FunctionalInterface
public interface Localizable {

    @NotNull Locale getLocale();

}
