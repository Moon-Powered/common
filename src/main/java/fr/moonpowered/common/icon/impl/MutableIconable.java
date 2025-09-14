package fr.moonpowered.common.icon.impl;

import fr.moonpowered.common.icon.Iconable;

public interface MutableIconable<T> extends Iconable<T> {

  @Override
  T getIcon();

  void setIcon(final T icon);
}
