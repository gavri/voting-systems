package com.example.gavri.polls

import org.scalatest._

class InstantRunoffSpec extends FunSpec with Matchers with Factory {
  describe("Instant Runoff") {
    it("should degenerate to plurality") {
      val first = ballotSheetFromCandidateNames("first")
      val second = ballotSheetFromCandidateNames("second")
      val winner = ballotSheetFromCandidateNames("winner")
      val fourth = ballotSheetFromCandidateNames("fourth")
      val instantRunoff = InstantRunoff(List(first, second , winner, winner, fourth))
      instantRunoff.winners should equal (Set(Candidate("winner")))
    }

    it("should promote the lower preferences of those who voted for the candidate with the least top votes") {
      val instantRunoff = InstantRunoff(ballots)
      instantRunoff.winners should equal (Set(Candidate("instant run off winner")))
    }

    it("should return an empty set if nobody voted") {
      val instantRunoff = InstantRunoff(List())
      instantRunoff.winners should equal (Set())
    }
  }
}
