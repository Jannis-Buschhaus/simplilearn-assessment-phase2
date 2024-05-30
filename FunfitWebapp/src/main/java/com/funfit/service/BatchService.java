package com.funfit.service;

import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.dao.BatchDao;

public class BatchService {
	public static String addBatch(Batch batch) {
		if(BatchDao.addBatch(batch) > 0) {
			return "Batch details added.";
		} else {
			return "Batch details were not added.";
		}
	}
	
	public static List<Batch> getBatch(){
		return BatchDao.getBatch();
	}
	
	public static String deleteBatch(int batchId) {
		if(BatchDao.deleteBatch(batchId) > 0) {
			return "Batch "+batchId+"deleted successfully";
		} else {
			return "Unable to delete batchID: "+batchId;
		}
	}
	
	public static List<Batch> updateBatch(Batch b) {
		List<Batch> lb = BatchDao.updateBatch(b);
		if(lb != null) {
			return lb;
		} else {
			return null;
		}
	}
}
