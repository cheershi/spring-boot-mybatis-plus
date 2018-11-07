package com.tnar.springbootmybatisplus.generate;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MyGenerate {
    public static void main(String[] args) {
        AutoGenerator mgp = new AutoGenerator();
        mgp.setTemplateEngine(new FreemarkerTemplateEngine());

        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("cf");
        gc.setOutputDir("E:\\workplace\\java_place\\spring-boot-mybatis-plus\\src\\main\\java");
        gc.setFileOverride(false);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(false);

        mgp.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/txq?useUnicode=true&characterEncoding=utf8");
        dsc.setUsername("root");
        dsc.setPassword("123456");

        mgp.setDataSource(dsc);

        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.nochange);
        sc.setInclude(new String[] {"weibo"});

        mgp.setStrategy(sc);

        PackageConfig pc = new PackageConfig();
        pc.setParent("com.tnar.springbootmybatisplus");

        mgp.setPackageInfo(pc);

        mgp.execute();

    }
}
