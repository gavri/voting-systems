package com.example.gavri.polls

import org.scalatest._

class CoombsSpec extends FunSpec with Matchers with Factory {
  describe("Coombs") {
    it("should degenerate to plurality") {
      val first = ballotSheetFromCandidateNames("first")
      val second = ballotSheetFromCandidateNames("second")
      val winner = ballotSheetFromCandidateNames("winner")
      val fourth = ballotSheetFromCandidateNames("fourth")
      val coombs = Coombs(List(first, second , winner, winner, fourth))
      coombs.winners should equal (Set(Candidate("winner")))
    }

    it("should promote the lower preferences of those who voted for the candidate with the most bottom votes") {
      val coombs = Coombs(ballots)
      coombs.winners should equal (Set(Candidate("coombs winner")))
    }

    it("should return an empty set if nobody voted") {
      val coombs = Coombs(List())
      coombs.winners should equal (Set())
    }
  }
}
