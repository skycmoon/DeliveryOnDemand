package edu.dod.core.service;

import edu.dod.core.domain.DemandHistory;
import edu.dod.core.domain.Item;
import edu.dod.core.domain.ItemMaxAllotmentForRoom;
import edu.dod.core.domain.ShortagePredictionCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * An implementation of {@link edu.dod.core.service.ItemShortagePredictorService}.
 *
 * @author sky
 * @version 140506
 */
@Service("ItemShortagePredictorService")
public class ItemShortagePredictorServiceImpl implements
		ItemShortagePredictorService {

    /**
     * ItemService to use item business logic.
     */
	@Autowired
	private ItemService itemService;

    /**
     * DemandHistoryService to use DemandHistory business logic.
     */
	@Autowired
	private DemandHistoryService demandHistory;

    /**
     * {@inheritDoc}
     */
	@Override
	public Collection<Item> predictItemShortage(
			ShortagePredictionCriteria shortagePredictionCriteria) {
		parseDateString(shortagePredictionCriteria.getExpectedDeliveryDate());
		Map<Integer, Integer> netItems = calculateTotalNumberOfItemsInStorage();
		Map<Integer, Integer> itemConsumption = calculateConsumptionOfItems();
		
		return null;
	}

    /**
     * Parse a date string.
     *
     * @param date a date string.
     * @return {@link java.util.Calendar}.
     */
	private Calendar parseDateString(String date) {
		String timestamp = date + " 00:00:00";
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(df.parse(timestamp));
			return cal;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

    /**
     * Calculate Total number of items in the storage.
     *
     * @return a map of item ID and total number of the items.
     */
	private Map<Integer, Integer> calculateTotalNumberOfItemsInStorage() {
		Map<Integer, Integer> itemMap = new HashMap<Integer, Integer>();
		Iterator<Item> items = itemService.findAllItems().iterator();
		Item tempItem;
		int subTotal;
		while (items.hasNext()) {
			tempItem = items.next();
			subTotal = 0;
			Iterator<ItemMaxAllotmentForRoom> imafr = tempItem.getItemMaxAllotmentForRooms().iterator();
			while (imafr.hasNext()) {
				subTotal += imafr.next().getItemMaxAllotment();
			}
			itemMap.put(tempItem.getItemId(), subTotal);
		}
		return null;
	}

    /**
     * Calculate consumption of the items.
     *
     * @return a map of item ID and the consumed numbers in last three months.
     */
	private Map<Integer, Integer> calculateConsumptionOfItems() {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Calendar current = Calendar.getInstance();
		Calendar calcStartPoint = Calendar.getInstance();
		calcStartPoint.add(Calendar.MONTH, -3);
		String calcStartPointString =  df.format(calcStartPoint.getTime());
		String currentString = df.format(current.getTime());
		Map<Integer, Integer> itemMap = new HashMap<Integer, Integer>();
		Iterator<DemandHistory> demandHistories = demandHistory.findAllDemandHistory().iterator();
		DemandHistory tempDH;
		int itemId;
		int demandQuantity;
		int temp;
		while (demandHistories.hasNext()) {
			tempDH = demandHistories.next();
			temp = 0;
			if (tempDH.getDeliveryStatus().getDeliveryStatus() == 1) {
				itemId = tempDH.getItem().getItemId();
				demandQuantity = tempDH.getDemandQuantity();
				if (itemMap.get(Integer.valueOf(itemId)) == null) {
					itemMap.put(Integer.valueOf(itemId), Integer.valueOf(demandQuantity));
				} else {
					temp = itemMap.get(Integer.valueOf(itemId));
					temp += demandQuantity;
					itemMap.put(Integer.valueOf(itemId), Integer.valueOf(temp));
				}
			}
		}
		return itemMap;
	}

}
