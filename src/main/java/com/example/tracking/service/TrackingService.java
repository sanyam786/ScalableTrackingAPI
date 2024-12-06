package com.example.tracking.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Cacheable("trackingNumbers")
public class TrackingService {

    @Async
    public CompletableFuture<String> generateTrackingNumber(String originCountryId, String destinationCountryId, double weight,
                                                            String createdAt, UUID customerId, String customerName, String customerSlug) {
        // Simulate a delay to mimic processing time (optional, for testing purposes)
        try {
            Thread.sleep(100); // Simulate a delay of 100ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String slugPrefix = customerSlug.toUpperCase().substring(0, 3);
        String timestampHash = Integer.toHexString(createdAt.hashCode());
        String randomSuffix = String.valueOf((int) (Math.random() * 10000));
        String trackingNumber = slugPrefix + originCountryId + destinationCountryId + timestampHash + randomSuffix;

        return CompletableFuture.completedFuture(
                trackingNumber.substring(0, Math.min(trackingNumber.length(), 16)).toUpperCase()
        );
    }
}