package com.myblog.transfer;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.myblog.schema.Blog;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ControllerSimple {
	Blog blog = null;
}
