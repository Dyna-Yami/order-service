package com.dmall.orderservice.adapter.inventory;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class InventoryClientFallback implements FallbackFactory<InventoryClient> {
    @Override
    public InventoryClient create(Throwable cause) {
        return new InventoryClient() {
            @Override
            public String lock(Lock lock) {
                return "000";
            }

            @Override
            public void unlock(String lockId) {
            }
        };
    }
}
