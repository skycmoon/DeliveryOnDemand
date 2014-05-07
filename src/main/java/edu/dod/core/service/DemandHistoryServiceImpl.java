package edu.dod.core.service;

import edu.dod.core.dao.DeliveryStatusDao;
import edu.dod.core.dao.DemandHistoryDao;
import edu.dod.core.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * An implementation of {@link edu.dod.core.service.DemandHistoryService}.
 *
 * @author sky
 * @version 140506
 */
@Service("DemandHistoryService")
public class DemandHistoryServiceImpl implements DemandHistoryService {

    /**
     * {@link edu.dod.core.dao.DemandHistoryDao} to access DemandHistory table.
     */
	@Autowired
	private DemandHistoryDao demandHistoryDao;

    /**
     * {@link edu.dod.core.dao.DeliveryStatusDao} to access DeliveryStatus table.
     */
	@Autowired
	private DeliveryStatusDao deliveryStatusDao;

    /**
     * RoomService to use Room business logic.
     */
	@Autowired
	private RoomService roomService;

    /**
     * ItemService to use Item business logic.
     */
	@Autowired
	private ItemService itemService;

    /**
     * {@inheritDoc}
     */
	@Override
	public Collection<DemandHistory> findAllDemandHistory() {
		return demandHistoryDao.findAll();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public DeliveryStatusForm extractDeliveryStatusForm(
			Collection<DemandHistory> demandHistories) {
		Iterator<DemandHistory> itr = demandHistories.iterator();
		DeliveryStatusForm dsf = new DeliveryStatusForm();
		List<DeliveryStatusCriteria> criteria = new ArrayList<>();
		DemandHistory temp;
		String demandId;
		String timeStamp;
		String roomId;
		String roomName;
		String itemId;
		String itemName;
		String quantity;
		String veracity;
		String deliveryStatus;
		while (itr.hasNext()) {
			temp = itr.next();
			demandId = String.valueOf(temp.getDemandId());
			timeStamp = temp.getTimestamp().toString();
			roomId = String.valueOf(temp.getRoom().getRoomId());
			roomName = temp.getRoom().getRoomName();
			itemId = String.valueOf(temp.getItem().getItemId());
			itemName = temp.getItem().getItemName();
			quantity = String.valueOf(temp.getDemandQuantity());
			veracity = String.valueOf(temp.getDeliveryStatus().getVeracity());
			deliveryStatus = String.valueOf(temp.getDeliveryStatus()
					.getDeliveryStatus());
			criteria.add(new DeliveryStatusCriteria(false, demandId, timeStamp,
					roomId, roomName, itemId, itemName, quantity, veracity,
					deliveryStatus));
		}
		dsf.setDeliveryStatusList(criteria);
		return dsf;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void updateDemandHistory(DemandForm demandForm) {
		Room room = roomService.findRoomById(demandForm.getRoomId());
		Item item = itemService.findItemById(demandForm.getItemId());
		int demandQuantity = Integer.parseInt(demandForm.getDemandQuantity());
		String demandReason = demandForm.getReason();
		DemandHistory demandHistory = new DemandHistory(room, item,
				demandQuantity, demandReason);
		DeliveryStatus ds = new DeliveryStatus(demandHistory.getDemandId(), 0, 0);
		demandHistory.setDeliveryStatus(ds);
		ds.setDemandHistory(demandHistory);
		demandHistoryDao.update(demandHistory);
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void updateDeliveryStatus(DeliveryStatusForm deliveryStatusForm) {
		Iterator<DeliveryStatusCriteria> itr = deliveryStatusForm.getDeliveryStatusList().iterator();
		DeliveryStatusCriteria dsc;
		DeliveryStatus tempDeliveryStatus;
		int demandId;
		int veracity;
		int deliveryStatus;
		int itemId;
		int deliveredQuantity;
		while (itr.hasNext()) {
			dsc = itr.next();
			if (dsc.isChangeCheckFlag()) {
				demandId = Integer.parseInt(dsc.getDemandId());
				veracity = Integer.parseInt(dsc.getVeracity());
				deliveryStatus = Integer.parseInt(dsc.getDeliveryStatus());
				tempDeliveryStatus = deliveryStatusDao.findById(demandId);
				tempDeliveryStatus.setVeracity(veracity);
				tempDeliveryStatus.setDeliveryStatus(deliveryStatus);
				deliveryStatusDao.update(tempDeliveryStatus);
				if (deliveryStatus == 1) {
					itemId = Integer.parseInt(dsc.getItemId());
					deliveredQuantity = Integer.parseInt(dsc.getQuantity());
					updateQuantityOnHandForTheItem(itemId, deliveredQuantity);
				}
			}
		}
	}

    /**
     * Update a quantity on hand (storage) for the item.
     *
     * @param itemId Item ID.
     * @param deliveredQuantity Delivered quantity in integer.
     */
	private void updateQuantityOnHandForTheItem(int itemId, int deliveredQuantity) {
		Item item = itemService.findItemById(itemId);
		int quantityOnHand = item.getQuantityOnHand();
		item.setQuantityOnHand(quantityOnHand - deliveredQuantity);
		itemService.updateItem(item);
	}

}
