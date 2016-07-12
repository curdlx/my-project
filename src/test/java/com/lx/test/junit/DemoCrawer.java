package com.lx.test.junit;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.ram.RamCrawler;

/**
 * Created by lx199 on 2016/7/12.
 */
public class DemoCrawer  extends RamCrawler{

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        System.out.println(page.doc().head());
    }

    public static void main(String[] args) throws Exception {
        DemoCrawer crawer = new DemoCrawer();
        CrawlDatum datum = new CrawlDatum("http://dtts.soyinke.com").meta("depth","1");

        crawer.addSeed(datum);
        crawer.start(1);
    }

}
