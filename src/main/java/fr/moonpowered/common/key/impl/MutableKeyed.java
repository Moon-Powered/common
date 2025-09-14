package fr.moonpowered.common.key.impl;

import fr.moonpowered.common.key.Keyed;

public interface MutableKeyed<T> extends Keyed<T> {

  @Override
  T getKey();

  void setKey(final T key);
}
