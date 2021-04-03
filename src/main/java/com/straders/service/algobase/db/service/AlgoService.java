package com.straders.service.algobase.db.service;

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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlgoService {

	RangeBoundService rangeService;

	PlaceOrderService orderService;

	ExitOrderService exitService;

	ConfirmOrderService confirmService;

	DailyService dailyService;

	DailyReturnService dailyReturns;

	HistoryService history;

	FultaService fultaService;

	TrendService trendService;

	IndexService indexService;

	StockService stockService;

	TrailOrderService trailService;

}
