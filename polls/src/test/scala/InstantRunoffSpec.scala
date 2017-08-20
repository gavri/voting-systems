package com.example.gavri.polls

import org.scalatest._

class InstantRunoffSpec extends FunSpec with Matchers with Factory {
  describe("Instant Runoff") {
    it("should degenerate to plurality") {
      val firstCandidate = Candidate("first candidate")
      val firstBallotSheet = BallotSheet(List(firstCandidate))
      val secondBallotSheet = BallotSheet(List(Candidate("second candidate")))
      val thirdBallotSheet = BallotSheet(List(firstCandidate))
      val instantRunoff = InstantRunoff(List(firstBallotSheet, secondBallotSheet , thirdBallotSheet))
      instantRunoff.winners should equal (Set(firstCandidate))
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
