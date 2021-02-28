package com.bitweb.votingapp.worker.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.io.Serializable;

public class AssignedSequenceStyleGenerator extends SequenceStyleGenerator {
    @Override
    public final Serializable generate(final SharedSessionContractImplementor session,
                                       final Object obj) {
        if (obj instanceof Identifiable) {
            @SuppressWarnings("rawtypes")
            final Identifiable identifiable = (Identifiable) obj;
            final Serializable id = identifiable.getId();
            if (id != null) {
                return id;
            }
        }
        return super.generate(session, obj);
    }
}
