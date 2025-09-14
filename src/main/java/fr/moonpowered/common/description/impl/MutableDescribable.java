package fr.moonpowered.common.description.impl;

import fr.moonpowered.common.description.Describable;

public interface MutableDescribable<T> extends Describable<T> {

  @Override
  T getDescription();

  void setDescription(final T description);
}
