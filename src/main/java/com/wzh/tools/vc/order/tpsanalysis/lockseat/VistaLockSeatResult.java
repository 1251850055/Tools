package com.wzh.tools.vc.order.tpsanalysis.lockseat;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangzehui
 * @date 2018/6/26 10:53
 */

public class VistaLockSeatResult implements Serializable {

    /**
     * ErrorDescription : Ticket Type 0028 could not be added to the order because the booking fee override provided is below the minimum booking fee
     * Result : 1
     * AreaSummaryData :
     * AvailableSeats : -1
     * ExtendedResultCode : 64
     * MaxSeatsPerRow : 0
     * Order : null
     * RedemptionsRemainingForVouchers : []
     * SeatData :
     * SeatDataLength : 0
     * SeatLayoutData : null
     * SeatsNotAllocated : false
     * SessionStatuses : [{"MaximumNumberOfSeatsPerRow":0,"NumberOfSeatsAvailable":0,"SessionId":18633}]
     */

    private String ErrorDescription;
    private int Result;
    private String AreaSummaryData;
    private int AvailableSeats;
    private int ExtendedResultCode;
    private int MaxSeatsPerRow;
    private Object Order;
    private String SeatData;
    private int SeatDataLength;
    private Object SeatLayoutData;
    private boolean SeatsNotAllocated;
    private List<?> RedemptionsRemainingForVouchers;
    private List<SessionStatusesBean> SessionStatuses;

    public String getErrorDescription() {
        return ErrorDescription;
    }

    public void setErrorDescription(String ErrorDescription) {
        this.ErrorDescription = ErrorDescription;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int Result) {
        this.Result = Result;
    }

    public String getAreaSummaryData() {
        return AreaSummaryData;
    }

    public void setAreaSummaryData(String AreaSummaryData) {
        this.AreaSummaryData = AreaSummaryData;
    }

    public int getAvailableSeats() {
        return AvailableSeats;
    }

    public void setAvailableSeats(int AvailableSeats) {
        this.AvailableSeats = AvailableSeats;
    }

    public int getExtendedResultCode() {
        return ExtendedResultCode;
    }

    public void setExtendedResultCode(int ExtendedResultCode) {
        this.ExtendedResultCode = ExtendedResultCode;
    }

    public int getMaxSeatsPerRow() {
        return MaxSeatsPerRow;
    }

    public void setMaxSeatsPerRow(int MaxSeatsPerRow) {
        this.MaxSeatsPerRow = MaxSeatsPerRow;
    }

    public Object getOrder() {
        return Order;
    }

    public void setOrder(Object Order) {
        this.Order = Order;
    }

    public String getSeatData() {
        return SeatData;
    }

    public void setSeatData(String SeatData) {
        this.SeatData = SeatData;
    }

    public int getSeatDataLength() {
        return SeatDataLength;
    }

    public void setSeatDataLength(int SeatDataLength) {
        this.SeatDataLength = SeatDataLength;
    }

    public Object getSeatLayoutData() {
        return SeatLayoutData;
    }

    public void setSeatLayoutData(Object SeatLayoutData) {
        this.SeatLayoutData = SeatLayoutData;
    }

    public boolean isSeatsNotAllocated() {
        return SeatsNotAllocated;
    }

    public void setSeatsNotAllocated(boolean SeatsNotAllocated) {
        this.SeatsNotAllocated = SeatsNotAllocated;
    }

    public List<?> getRedemptionsRemainingForVouchers() {
        return RedemptionsRemainingForVouchers;
    }

    public void setRedemptionsRemainingForVouchers(List<?> RedemptionsRemainingForVouchers) {
        this.RedemptionsRemainingForVouchers = RedemptionsRemainingForVouchers;
    }

    public List<SessionStatusesBean> getSessionStatuses() {
        return SessionStatuses;
    }

    public void setSessionStatuses(List<SessionStatusesBean> SessionStatuses) {
        this.SessionStatuses = SessionStatuses;
    }

    public static class SessionStatusesBean {
        /**
         * MaximumNumberOfSeatsPerRow : 0
         * NumberOfSeatsAvailable : 0
         * SessionId : 18633
         */

        private int MaximumNumberOfSeatsPerRow;
        private int NumberOfSeatsAvailable;
        private int SessionId;

        public int getMaximumNumberOfSeatsPerRow() {
            return MaximumNumberOfSeatsPerRow;
        }

        public void setMaximumNumberOfSeatsPerRow(int MaximumNumberOfSeatsPerRow) {
            this.MaximumNumberOfSeatsPerRow = MaximumNumberOfSeatsPerRow;
        }

        public int getNumberOfSeatsAvailable() {
            return NumberOfSeatsAvailable;
        }

        public void setNumberOfSeatsAvailable(int NumberOfSeatsAvailable) {
            this.NumberOfSeatsAvailable = NumberOfSeatsAvailable;
        }

        public int getSessionId() {
            return SessionId;
        }

        public void setSessionId(int SessionId) {
            this.SessionId = SessionId;
        }
    }
}
