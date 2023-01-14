package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public interface d extends IInterface {
    void a(ConnectionResult connectionResult, zaa zaa) throws RemoteException;

    void a(Status status) throws RemoteException;

    void a(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void a(zaj zaj) throws RemoteException;

    void b(Status status) throws RemoteException;
}
