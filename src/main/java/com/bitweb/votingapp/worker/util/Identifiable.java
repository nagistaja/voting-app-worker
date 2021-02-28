package com.bitweb.votingapp.worker.util;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {
    T getId();
}
