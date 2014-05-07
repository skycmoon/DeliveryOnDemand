package edu.dod.core.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * ItemType domain representing a item type.
 *
 * @author sky
 * @version 140506
 */
@Entity
@Table(name = "ItemTypes")
public class ItemType {

    /**
     * Item type ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int itemTypeId;

    /**
     * Item type name.
     */
    @Column(name = "type_name")
    private String itemTypeName;

    /**
     * Items in this item type.
     * <p>
     * mappedBy means the property in the Room class that provides the
     * association(foreign key)
     * </p>
     */
    @OneToMany(mappedBy = "itemType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items = new HashSet<Item>();

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int typeId) {
        this.itemTypeId = typeId;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String typeName) {
        this.itemTypeName = typeName;
    }

    public Set<Item> getItems() {
        return this.items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

}
