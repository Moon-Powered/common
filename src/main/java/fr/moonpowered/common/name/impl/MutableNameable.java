package fr.moonpowered.common.name.impl;

import fr.moonpowered.common.name.Nameable;

public interface MutableNameable<T> extends Nameable<T> {

  @Override
  T getName();

  void setName(final T name);
}
