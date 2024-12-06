package com.example.tracking.service;

import com.example.tracking.model.TrackingResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class TrackingService {

    @Async
    public CompletableFuture<TrackingResponse> generateTrackingNumber(String originCountryId, String destinationCountryId, double weight,
                                                                      String createdAt, UUID customerId, String customerName, String customerSlug) {
        String slugPrefix = customerSlug.toUpperCase().substring(0, 3);
        String timestampHash = Integer.toHexString(createdAt.hashCode());
        String randomSuffix = String.valueOf((int) (Math.random() * 10000));
        String trackingNumber = slugPrefix + originCountryId + destinationCountryId + timestampHash + randomSuffix;

        // Format the current timestamp in RFC 3339 format
        String timestamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now());

        // Create and return the TrackingResponse object
        TrackingResponse response = new TrackingResponse(
                trackingNumber.substring(0, Math.min(trackingNumber.length(), 16)).toUpperCase(),
                timestamp
        );

        return CompletableFuture.completedFuture(response);
    }
}