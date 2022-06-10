package com.example.proiectfmi.ui.maps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016J+\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0\'2\u0006\u0010)\u001a\u00020*H\u0016\u00a2\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020(2\u0006\u0010%\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/example/proiectfmi/ui/maps/MapsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "LOCATION_REQUEST_CODE", "", "_binding", "Lcom/example/proiectfmi/databinding/FragmentMapsBinding;", "binding", "getBinding", "()Lcom/example/proiectfmi/databinding/FragmentMapsBinding;", "googleMap", "Lcom/google/android/gms/maps/GoogleMap;", "getGoogleMap", "()Lcom/google/android/gms/maps/GoogleMap;", "setGoogleMap", "(Lcom/google/android/gms/maps/GoogleMap;)V", "mapFragment", "Lcom/google/android/gms/maps/SupportMapFragment;", "getMapFragment", "()Lcom/google/android/gms/maps/SupportMapFragment;", "setMapFragment", "(Lcom/google/android/gms/maps/SupportMapFragment;)V", "mapsViewModel", "Lcom/example/proiectfmi/ui/maps/MapsViewModel;", "mapReadyCallback", "", "it", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermission", "permissionType", "app_debug"})
public final class MapsFragment extends androidx.fragment.app.Fragment {
    private com.example.proiectfmi.ui.maps.MapsViewModel mapsViewModel;
    private com.example.proiectfmi.databinding.FragmentMapsBinding _binding;
    public com.google.android.gms.maps.SupportMapFragment mapFragment;
    public com.google.android.gms.maps.GoogleMap googleMap;
    private final int LOCATION_REQUEST_CODE = 101;
    private java.util.HashMap _$_findViewCache;
    
    public MapsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.maps.SupportMapFragment getMapFragment() {
        return null;
    }
    
    public final void setMapFragment(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.SupportMapFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.maps.GoogleMap getGoogleMap() {
        return null;
    }
    
    public final void setGoogleMap(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap p0) {
    }
    
    private final com.example.proiectfmi.databinding.FragmentMapsBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void mapReadyCallback(com.google.android.gms.maps.GoogleMap it) {
    }
    
    private final void requestPermission(java.lang.String permissionType, int requestCode) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}