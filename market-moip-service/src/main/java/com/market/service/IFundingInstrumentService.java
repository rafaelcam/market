package com.market.service;

import br.com.moip.request.FundingInstrumentRequest;
import com.market.wrapper.CustomerWrapper;
import com.market.wrapper.PaymentWrapper;

public interface IFundingInstrumentService {

    FundingInstrumentRequest makeFundingInstrument(PaymentWrapper paymentWrapper, CustomerWrapper customerWrapper) throws Exception;
}