package com.mxc.config;

import com.isyscore.isc.mikilin.spring.MkAop;
import com.isyscore.isc.mikilin.spring.MkSpringBeanContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 将Mikilin的核查接入spring
 *
 * @author robot
 */
@Import({MkSpringBeanContext.class, MkAop.class})
@Configuration
public class MkConfiguration {
}
