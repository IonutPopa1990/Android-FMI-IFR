package com.example.proiectfmi.db.contacts;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ContactDataDao_Impl implements ContactDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfContactData;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ContactDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContactData = new EntityInsertionAdapter<ContactData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `contact_table`(`lastName`,`firstName`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ContactData value) {
        if (value.getLastName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getLastName());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirstName());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM contact_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ContactData contact) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfContactData.insert(contact);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<ContactData>> getAll() {
    final String _sql = "SELECT * FROM contact_table ORDER BY lastName ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"contact_table"}, false, new Callable<List<ContactData>>() {
      @Override
      public List<ContactData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final List<ContactData> _result = new ArrayList<ContactData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ContactData _item;
            final String _tmpLastName;
            _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            final String _tmpFirstName;
            _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            _item = new ContactData(_tmpLastName,_tmpFirstName);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
