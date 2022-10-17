package com.ruoyi.ruoyiapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Jpa抽象接口
 *
 * @author guoxi_789@126.com
 * @date 2022/10/15
 */
public interface AbstractRepository<T> extends PagingAndSortingRepository<T,Integer> {
}
