package com.market.service;

import br.com.moip.request.CreditCardRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.TaxDocumentRequest;
import com.market.wrapper.CustomerWrapper;
import com.market.wrapper.PaymentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundingInstrumentService implements IFundingInstrumentService {

    @Autowired
    IPhoneService phoneService;

    @Override
    public FundingInstrumentRequest makeFundingInstrument(PaymentWrapper paymentWrapper, CustomerWrapper customerWrapper) throws Exception {
        return new FundingInstrumentRequest().creditCard(makeCreditCardRequest(paymentWrapper, customerWrapper));
    }

    private CreditCardRequest makeCreditCardRequest(PaymentWrapper paymentWrapper, CustomerWrapper customerWrapper) throws Exception {
        return new CreditCardRequest()
                .hash(paymentWrapper.getHash())
                .holder(new HolderRequest()
                        .birthdate(customerWrapper.getDateBirth().toString())
                        .fullname(paymentWrapper.getName())
                        .phone(phoneService.makePhoneRequest(customerWrapper))
                        .taxDocument(TaxDocumentRequest.cpf(customerWrapper.getCpf()))
                );
    }
}