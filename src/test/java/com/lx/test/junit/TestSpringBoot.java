package com.lx.test.junit;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.lx.test.SpringBootRun;
import com.lx.test.model.mybatis.Address;
import com.lx.test.model.mybatis.User;
import com.lx.test.repository.AddressMapper;
import com.lx.test.repository.JedisDaoimpl;
import com.lx.test.repository.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by lx on 2016/6/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootRun.class)
public class TestSpringBoot {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private JedisDaoimpl jedisDaoimpl;
    @Test
    public void test1() {
        User user = userMapper.selectByPrimaryKey(1);
        Assert.assertNotNull(user);

    }

    @Test
    public void test2() {
        User user = new User();
        user.setId(1);
        user.setName("lixin");
        String s = JSON.toJSONString(user);
        System.out.println(s);
    }

    @Test
    public void test3() throws Exception {
        DemoCrawler crawler = new DemoCrawler();
        List<Address> results = crawler.getResults(crawler);
        ListIterator<Address> iterator = results.listIterator();
        Map<Integer,Address> map = new HashMap<Integer, Address>();
        while (iterator.hasNext()) {
            Address address = iterator.next();
//            System.out.println(address.getName()+"#############"+address.getpName());
            if ("自治区直辖县级行政区划".equals(address.getName())|| "县".equals(address.getName()) || "市辖区".equals(address.getName()) || "省直辖县级行政区划".equals(address.getName()))
            {
                System.out.println(address.getName() + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + address.getpName());
                iterator.remove();
                continue;
            }

            if(address.getPid()==null||address.getPid()==0){
                map.put(address.getId(),address);
                iterator.remove();
            }

        }
//        ListIterator<Address> it = results.listIterator();
//        while (it.hasNext()){
//            Address next = it.next();
//            if(next.getPid()!=null){
//                Address address = map.get(next.getPid());
//                if (address!=null){
//                    address.getCitys().add(next);
//                }
//            }
//        }
//        System.out.println(results.size());
        Set<Integer> keySet = map.keySet();
        //foreach provice get cities
        for(Integer key : keySet){
            List<Address> cities = new ArrayList<Address>();
            Address address = map.get(key);

            for (Address city:results){
                if(city.getPid().intValue()==address.getId()){
                    cities.add(city);
                }
                List<Address> countries = new ArrayList<Address>();
                for (Address country:results){
                    if(country.getPid().intValue()==city.getId()){
                        countries.add(country);
                    }
                }
                city.setCountrys(countries);
            }
            address.setCitys(cities);
        }

//        Address henan = map.get(41);
//        System.out.print("henan province has city:");
//        for (Address city:henan.getCitys()){
//            if(city.getName().equals("信阳市")){
//                System.out.println("...");
//            }
//            System.out.println(city.getName());
//            System.out.println(city.getName()+":has country:");
//            for (Address country:city.getCountrys()){
//                System.out.printf("$$country:"+country.getName());
//            }
//        }
        Set<Integer> ids = map.keySet();
        for (Integer id : ids){
            Address province = map.get(id);
            //insert province
            addressMapper.insert(province);
            for (Address city:province.getCitys()){
                addressMapper.insert(city);
                for (Address country:city.getCountrys()){
                    addressMapper.insertSelective(country);
                }
            }
        }
    }

}
