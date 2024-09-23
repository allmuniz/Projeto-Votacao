package project.muniz.vote_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.muniz.vote_api.model.ParameterModel;

public interface ParameterRepository extends MongoRepository<ParameterModel, String> {
}
