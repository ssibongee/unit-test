package com.unittest.store;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CustomerTestLondon {

    private Store store = mock(Store.class);

    @Test
    void 재고가_충분할_때_상품구매_성공() {
        // given
        given(store.hasEnoughInventory(any(Product.class), anyInt())).willReturn(true);
        Customer customer = new Customer();

        // when
        boolean success = customer.purchase(store, Product.SHAMPOO, 5);

        // then
        Assertions.assertThat(success).isTrue();
        verify(store, times(1)).hasEnoughInventory(any(Product.class), anyInt());
    }

    @Test
    void 재고가_충분하지_않을_때_상품구매_실패() {
        // given
        given(store.hasEnoughInventory(any(Product.class), anyInt())).willReturn(false);
        Customer customer = new Customer();

        // when
        boolean success = customer.purchase(store, Product.SHAMPOO, 5);

        // then
        Assertions.assertThat(success).isFalse();
        verify(store, times(0)).removeFromInventory(any(Product.class), anyInt());
    }
}
