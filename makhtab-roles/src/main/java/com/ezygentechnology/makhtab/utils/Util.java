package com.ezygentechnology.makhtab.utils;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

import com.ezygentechnology.makhtab.role.constant.MKHTB_Constans;

public class Util {
	
	public static String replaceSchema(String sql, String schemaName) {
		if (null == schemaName) {
			schemaName = "";//if schema name is null then will try to connect default schema ebdb
		}
		String _sql = sql.replaceAll(MKHTB_Constans.DYNAMIC_SCHAME, schemaName);
		return _sql;
	}

	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
	private static final Pattern EDGESDHASHES = Pattern.compile("(^-|-$)");

	public static String toSlug(String input) {
	    String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
	    String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
	    String slug = NONLATIN.matcher(normalized).replaceAll("");
	    slug = EDGESDHASHES.matcher(slug).replaceAll("");
	    return slug.toLowerCase(Locale.ENGLISH);
	}
	
	/*
	 * public static void main(String args[]) {
	 * System.out.println(toSlug("vaquar khan test!!") ); }
	 */

}
