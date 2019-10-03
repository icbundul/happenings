package com.nativehappenings.happenings.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 *
 * OrderedBaseEntity provides orderNumber column that is used to maintain the
 * persistent order of a list of slaves entities in a master-slave entity
 * relationship SLave entity has to be subclass of OrderedBaseEntity. In a
 * master entity, the list of slaves has to be annotated with @OrderColumn.
 * Example:
 *
 * 	@Entity
 * 	public class Document {
 *
 *			@Id long id;
 *
 * 			@OneToMany // unidirectional
 * 			@OrderColumn(name="orderNumber")
 *          List<DocumentItem> items; ... }
 *
 *
 * 	@Entity
 * 	public class DocumentItem extends OrderedBaseEntity {
 *     ...... }
 *
 *
 */
@MappedSuperclass
public abstract class OrderedBaseEntity extends BaseEntity {

    /** Universal version identifier for a {@link Serializable} class */
    private static final long serialVersionUID = 1L;

    /** Defines order number */
    @Column(nullable = false)
    private Integer orderNumber = 0;

    /**
     * @return the orderNumber
     */
    public Integer getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

}
