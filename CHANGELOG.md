# Changelog

All notable changes to the Mailinator Java Client SDK will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [2.4.0] - 2026-03-23

### Deprecated

- **Rule management** (`CreateRuleRequest`, `DeleteRuleRequest`, `DisableRuleRequest`, `EnableRuleRequest`, `GetRuleRequest`, `GetRulesRequest`): rules engine endpoints have been deprecated in the Mailinator API and will be removed in a future release.
- **Domain management** (`CreateDomainRequest`, `DeleteDomainRequest`): domain creation and deletion via the SDK are deprecated; use the Mailinator web UI instead.
- **Authenticator list endpoints** (`GetAuthenticatorRequest`, `GetAuthenticatorByIdRequest`, `GetAuthenticatorsRequest`): not present in the current OpenAPI specification; use `GetAuthenticatorsByIdRequest` for authenticator lookup.
- **Legacy wildcard message endpoints** (`GetLatestMessagesRequest`, `GetLatestInboxMessagesRequest`): removed from the current OpenAPI specification and known to return server errors; use `GetInboxRequest` instead.

### Added

- `GetSmsInboxRequest`: added full inbox-list query parameter support — `skip`, `limit`, `sort`, `decode_subject`, `cursor`, `full`, `wait`, `delete` — to align with the OpenAPI contract.
- `GetInboxMessageRequest`: added optional `delete` query parameter, allowing a message to be deleted upon retrieval (mirrors `GetMessageRequest` behaviour).

### Fixed

- Updated `USER_AGENT` header to `Mailinator SDK - Java V2.4`.

---

## [2.3.0] - 2026-03-23

### Changed

- **Replaced Jackson with json-simple for all JSON serialization/deserialization.**
  Jackson's strict schema validation (`UnrecognizedPropertyException`) caused failures whenever the Mailinator API added new fields. json-simple silently ignores unknown fields, making the SDK resilient to API schema evolution.

#### Infrastructure

- `pom.xml`: Removed `jersey-media-json-jackson` dependency; added `com.googlecode.json-simple:json-simple:1.1.1`.
- `JerseyClient.java`: Removed `JacksonFeature` registration from Jersey client configuration.
- `JsonUtils.java` _(new)_: Added utility class with helpers `parseObject`, `getString`, `getInteger`, `getLong`, `getBoolean`, `getObject`, `getList`, and `getStringList` for safe json-simple parsing.

#### Model / DTO classes — Jackson annotations removed, manual `fromJson(JSONObject)` factory methods added

- `ResponseStatus`
- `DeletedMessages`
- `PrivateWebhookResponse`
- `EmailLogEntry`
- `LinkEntity`
- `MembersItem`
- `SmsNumbersItem`
- `PrivateDomainsItem`
- `Retrieved`
- `Sent`
- `PlanData`
- `Authenticator` (field names also normalised: `Id→id`, `TimeStep→timeStep`, etc.)
- `GetAuthenticatorsResponse`
- `InstantTOTP2FACodeResponse`
- `Links`
- `LinksFull`
- `Attachment`
- `Attachments`
- `Part`
- `SmtpLog`
- `Message`
- `Inbox`
- `PostedMessage`
- `StatsItem`
- `Stats`
- `TeamInfo`
- `Team`
- `Domain`
- `Domains`
- `ActionData` — added `toJSON()` for request serialization
- `ConditionData` — added `toJSON()` for request serialization
- `Action` — added `toJSON()` for request serialization
- `Condition` — added `toJSON()` for request serialization
- `Rule`
- `Rules`
- `RuleToCreate` — added `toJSON()` (request body only)
- `Webhook` — added `toJSON()` (request body only)
- `MessageToPost` — added `toJSON()` (request body only)

#### Request classes — Jersey now deserializes to `String` and `fromJson` is used instead of POJO binding

- **authenticator**: `GetAuthenticatorByIdRequest`, `GetAuthenticatorsByIdRequest`, `GetAuthenticatorRequest`, `GetAuthenticatorsRequest`, `InstantTOTP2FACodeRequest`
- **domain**: `CreateDomainRequest`, `DeleteDomainRequest`, `GetDomainRequest`, `GetDomainsRequest`
- **message**: `DeleteDomainMessagesRequest`, `DeleteInboxMessagesRequest`, `DeleteMessageRequest`, `GetInboxMessageAttachmentsRequest`, `GetInboxMessageLinksRequest`, `GetInboxMessageRequest`, `GetInboxMessageSmtpLogRequest`, `GetInboxRequest`, `GetLatestInboxMessagesRequest`, `GetLatestMessagesRequest`, `GetMessageAttachmentsRequest`, `GetMessageLinksFullRequest`, `GetMessageLinksRequest`, `GetMessageRequest`, `GetMessageSmtpLogRequest`, `GetSmsInboxRequest`, `PostMessageRequest`
- **rule**: `CreateRuleRequest`, `DeleteRuleRequest`, `DisableRuleRequest`, `EnableRuleRequest`, `GetRuleRequest`, `GetRulesRequest`
- **stats**: `GetStatsRequest`, `GetTeamInfoRequest`, `GetTeamRequest`
- **webhook**: `PrivateWebhookRequest`, `PrivateInboxWebhookRequest`, `PrivateCustomServiceWebhookRequest`, `PrivateCustomServiceInboxWebhookRequest`

### Fixed

- Removed reference to `JacksonObjectMapperProvider` class that was missing from the codebase, which would have caused a compilation failure.

---

## [2.2.0] - prior release

- Initial public release of the Mailinator Java Client SDK.
