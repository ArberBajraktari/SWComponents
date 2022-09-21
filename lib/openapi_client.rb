=begin
#OpenAPI Petstore

#This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.

The version of the OpenAPI document: 1.0.0

Generated by: https://openapi-generator.tech
OpenAPI Generator version: 6.1.0

=end

# Common files
require 'openapi_client/api_client'
require 'openapi_client/api_error'
require 'openapi_client/version'
require 'openapi_client/configuration'

# Models
require 'openapi_client/models/api_response'
require 'openapi_client/models/category'
require 'openapi_client/models/order'
require 'openapi_client/models/pet'
require 'openapi_client/models/tag'
require 'openapi_client/models/user'

# APIs
require 'openapi_client/api/pet_api'
require 'openapi_client/api/store_api'
require 'openapi_client/api/user_api'

module OpenapiClient
  class << self
    # Customize default settings for the SDK using block.
    #   OpenapiClient.configure do |config|
    #     config.username = "xxx"
    #     config.password = "xxx"
    #   end
    # If no block given, return the default Configuration object.
    def configure
      if block_given?
        yield(Configuration.default)
      else
        Configuration.default
      end
    end
  end
end
