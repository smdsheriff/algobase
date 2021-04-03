package com.straders.service.algobase.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.straders.service.algobase.db.service.AlgoService;
import com.straders.service.algobase.db.service.transaction.ConfirmOrderService;
import com.straders.service.algobase.db.service.transaction.DailyReturnService;
import com.straders.service.algobase.db.service.transaction.DailyService;
import com.straders.service.algobase.db.service.transaction.ExitOrderService;
import com.straders.service.algobase.db.service.transaction.FultaService;
import com.straders.service.algobase.db.service.transaction.HistoryService;
import com.straders.service.algobase.db.service.transaction.IndexService;
import com.straders.service.algobase.db.service.transaction.PlaceOrderService;
import com.straders.service.algobase.db.service.transaction.RangeBoundService;
import com.straders.service.algobase.db.service.transaction.StockService;
import com.straders.service.algobase.db.service.transaction.TrailOrderService;
import com.straders.service.algobase.db.service.transaction.TrendService;

public abstract class AlgoController {

	@Autowired
	RangeBoundService rangeBoundService;

	@Autowired
	PlaceOrderService placeOrderService;

	@Autowired
	ConfirmOrderService confirmService;

	@Autowired
	ExitOrderService exitService;

	@Autowired
	DailyService dailyService;

	@Autowired
	DailyReturnService dailyReturns;

	@Autowired
	HistoryService dailyHistory;

	@Autowired
	FultaService fulta;

	@Autowired
	TrendService trend;

	@Autowired
	IndexService index;

	@Autowired
	StockService stock;

	@Autowired
	TrailOrderService trail;

	public AlgoService algoService() {
		AlgoService service = new AlgoService();
		service.setRangeService(rangeBoundService);
		service.setOrderService(placeOrderService);
		service.setConfirmService(confirmService);
		service.setExitService(exitService);
		service.setDailyService(dailyService);
		service.setDailyReturns(dailyReturns);
		service.setHistory(dailyHistory);
		service.setFultaService(fulta);
		service.setTrendService(trend);
		service.setIndexService(index);
		service.setStockService(stock);
		service.setTrailService(trail);
		return service;
	}

}
