package com.bitweb.votingapp.worker.entity;

import com.bitweb.votingapp.worker.constant.FieldsLength;
import com.bitweb.votingapp.worker.constant.ValidationMessages;
import com.bitweb.votingapp.worker.entity.base.BaseEntity;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "survey")
@GenericGenerator(
        name = "assigned-sequence",
        strategy = "com.bitweb.votingapp.worker.util.AssignedSequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "surveys_id_seq"),
                @org.hibernate.annotations.Parameter(
                        name = "optimizer",
                        value = "none")
        })
public class Survey extends BaseEntity {
    private static final long serialVersionUID = 6268067357854489063L;

    private String name;
    private List<Question> questions;
    private String description;
    private Timestamp startedAt;
    private Timestamp closedAt;
    private Date startDate;
    private Date endDate;

    public Survey() {
        super();
    }

    /**
     * Get survey display name
     * @return survey name
     */
    @NotNull(message = ValidationMessages.NOT_NULL)
    @Size(max = FieldsLength.SURVEY_NAME, message = ValidationMessages.MAX_LENGTH_EXCEEDED)
    @Column(length = FieldsLength.SURVEY_NAME, nullable = false)
    public String getName() {
        return name;
    }

    /**
     * Get questions in survey
     * @return questions
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "survey")
    @OrderBy("id ASC")
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Get survey description, not visible to user
     * @return survey description
     */
    @Size(max = FieldsLength.SURVEY_DESCRIPTION, message = ValidationMessages.MAX_LENGTH_EXCEEDED)
    @Column(length = FieldsLength.SURVEY_DESCRIPTION)
    public String getDescription() {
        return description;
    }

    /**
     * Timestamp when survey was activated
     * @return start time
     */
    public Timestamp getStartedAt() {
        return startedAt;
    }

    /**
     * Timestamp when survey was closed
     * @return closed time
     */
    public Timestamp getClosedAt() {
        return closedAt;
    }

    /**
     * Can be used to schedule surveys and set the starting time
     * @return start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Can be used to set automatic end for survey
     * @return end date
     */
    public Date getEndDate() {
        return endDate;
    }
}
