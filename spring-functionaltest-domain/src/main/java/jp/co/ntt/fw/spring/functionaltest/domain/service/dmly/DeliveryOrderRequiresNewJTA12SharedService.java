/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.domain.service.dmly;

import java.util.List;

import jp.co.ntt.fw.spring.functionaltest.domain.model.DeliveryOrder;

public interface DeliveryOrderRequiresNewJTA12SharedService {

    void insert(List<DeliveryOrder> insertOrderList);

}
