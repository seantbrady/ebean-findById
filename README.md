This application is designed to showcase inconsistent and potentially dangerous behavior when searching by id's with Ebean in Play 2.1.  Running the unit tests will demonstrate the following:

1) When using Model.Finder.byId(I i), if i is NULL, a NullPointerException is thrown.  This is good!

2) When using Model.Finder.where().idEq(java.lang.Object o), if i is NULL, the query will return ALL rows from the table.  A typical use case would be to use this as idEq(myId).findUnique().  If there is more than one row in the table, then this will throw a persistence exception and be quite obvious.  This is inconsistent with the NPE, but not too dangerous.  However, if the table only has one matching row (assuming either a test with little data or other constraintsin the where() expression), then that one row will return with no exception -- no matter what the id is.  This is potentially quite dangerous.
