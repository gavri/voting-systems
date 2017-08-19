package com.example.gavri.polls

trait Factory {
  def ballotSheetFromCandidateNames(candidates: String*) = {
    BallotSheet(candidates.toList.map(c => Candidate(c)))
  }
}
