/**
 * This class is generated by jOOQ
 */
package com.myblog.schema.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User extends org.jooq.impl.TableImpl<com.myblog.schema.tables.records.UserRecord> {

	private static final long serialVersionUID = -828416841;

	/**
	 * The singleton instance of <code>blog.user</code>
	 */
	public static final com.myblog.schema.tables.User USER = new com.myblog.schema.tables.User();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.myblog.schema.tables.records.UserRecord> getRecordType() {
		return com.myblog.schema.tables.records.UserRecord.class;
	}

	/**
	 * The column <code>blog.user.user_id</code>. 
	 */
	public final org.jooq.TableField<com.myblog.schema.tables.records.UserRecord, java.lang.Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this);

	/**
	 * The column <code>blog.user.user_name</code>. 
	 */
	public final org.jooq.TableField<com.myblog.schema.tables.records.UserRecord, java.lang.String> USER_NAME = createField("user_name", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this);

	/**
	 * The column <code>blog.user.user_password</code>. 
	 */
	public final org.jooq.TableField<com.myblog.schema.tables.records.UserRecord, java.lang.String> USER_PASSWORD = createField("user_password", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this);

	/**
	 * The column <code>blog.user.registed_date</code>. 
	 */
	public final org.jooq.TableField<com.myblog.schema.tables.records.UserRecord, java.sql.Timestamp> REGISTED_DATE = createField("registed_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this);

	/**
	 * The column <code>blog.user.last_login</code>. 
	 */
	public final org.jooq.TableField<com.myblog.schema.tables.records.UserRecord, java.sql.Timestamp> LAST_LOGIN = createField("last_login", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this);

	/**
	 * Create a <code>blog.user</code> table reference
	 */
	public User() {
		super("user", com.myblog.schema.Blog.BLOG);
	}

	/**
	 * Create an aliased <code>blog.user</code> table reference
	 */
	public User(java.lang.String alias) {
		super(alias, com.myblog.schema.Blog.BLOG, com.myblog.schema.tables.User.USER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.myblog.schema.tables.records.UserRecord> getPrimaryKey() {
		return com.myblog.schema.Keys.KEY_USER_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.myblog.schema.tables.records.UserRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.myblog.schema.tables.records.UserRecord>>asList(com.myblog.schema.Keys.KEY_USER_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.myblog.schema.tables.User as(java.lang.String alias) {
		return new com.myblog.schema.tables.User(alias);
	}
}
