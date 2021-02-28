package com.bitweb.votingapp.worker.entity;

import com.bitweb.votingapp.worker.constant.ValidationMessages;
import com.bitweb.votingapp.worker.entity.base.BaseEntity;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "response")
@GenericGenerator(
        name = "assigned-sequence",
        strategy = "com.bitweb.votingapp.worker.util.AssignedSequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "responses_id_seq"),
                @org.hibernate.annotations.Parameter(
                        name = "optimizer",
                        value = "none")
        })
public class Response extends BaseEntity {
    private static final long serialVersionUID = 7392845196028264869L;

    private Answer answer;
    private Question question;
    private Date createdAt;

    public Response() {
        super();
    }

    /**
     * Get the answer response was for
     * @return answer
     */
    @NotNull(message = ValidationMessages.NOT_NULL)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "answer_id", nullable = false, updatable = false)
    public Answer getAnswer() {
        return answer;
    }

    /**
     * Get the question response was for
     * @return question
     */
    @NotNull(message = ValidationMessages.NOT_NULL)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false, updatable = false)
    public Question getQuestion() {
        return question;
    }

    /**
     * Get the time answer was submitted at
     * @return createdAt
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedAt() {
        return createdAt;
    }
}
