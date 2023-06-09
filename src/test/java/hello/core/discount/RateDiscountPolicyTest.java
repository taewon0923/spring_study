package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("10% 할인")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member,20000);
        //then
        Assertions.assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("vip가 아니면")
    void vip_x(){
        //given
        Member member =new Member(1L,"memberBASIC",Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}