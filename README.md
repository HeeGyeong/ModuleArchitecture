# Modular Architecture Sample

이 프로젝트는 Clean Architecture를 기반으로 하여 모듈 구조를 생성한 샘플 프로젝트입니다. 각 모듈은 View 단위로 나누어져 있으며, 공통적으로 사용하는 클래스를 Core 모듈에 관리하고 있습니다.

## 설명

이 샘플 코드는 Clean Architecture를 확장하여 View 단위 별로 모듈을 나누어 구현하였습니다. Core 모듈은 모든 모듈에서 공통적으로 사용하는 클래스를 관리하기 위해 만들어졌습니다.

## 아키텍처

- **Clean Architecture**: 이 프로젝트는 Clean Architecture를 기반으로 작성되었으며, Coordinator Pattern을 사용하여 화면 단위로 모듈이 나뉘어져 있습니다.
- 각 화면은 Presentation 모듈을 통해서만 이동할 수 있으며, Presentation 모듈은 Initializer를 통해 다른 화면을 호출합니다. 각 Activity 모듈은 Initializer를 통해서만 접근 가능하며, Initializer는 Presentation 모듈에서 접근할 수 있습니다. Initializer에서 전달받은 데이터를 컨트롤하여 Activity에 사용할 수 있도록 구현하였습니다.
- Data 및 Domain 모듈은 Clean Architecture와 동일한 역할을 수행합니다.

## Gradle

Gradle에서의 공통 코드를 최소화하고 관리의 용이성을 높이기 위해 Gradle을 공통화하였습니다. 
- `android.gradle` 파일에는 compile, buildTools, targetSdk 등 기본적인 Android 설정이 포함되어 있습니다.
- 추가로 작성한 Gradle 파일은 파일 이름을 통해 직관적으로 어떤 값이 들어있는지 알 수 있도록 하였습니다.
- 2022.05: Gradle Version 7.2 대응 작업.
- 2022.05: Build Type 및 Product Flavors 추가.

## 의존성 주입 (DI)

Koin을 사용하여 의존성 주입을 구현하였으며, Gradle Version 7.2와 함께 Koin Version 3.2로 최신화하였습니다.

## 생체 인증 (Biometric)

Biometric 1.1.0 버전을 사용하여 생체 인증을 구현하였습니다. 
- 패턴 인증을 사용할 수 있도록 구분하였으며, 패턴을 사용하지 않을 경우 지문 인증 및 얼굴 인증을 사용할 수 있도록 설정하였습니다.
- 관련된 내용은 [블로그](https://heegs.tistory.com/132 "How to use Biometric")에 작성되어 있으며, 주석으로 추가되어 있어 코드만 확인해도 무관합니다.

## 블로그

Modular Architecture에 대한 자세한 설명은 다음 블로그에서 확인할 수 있습니다: [Tistory Blog](https://heegs.tistory.com/69?category=915533 "Modular Architecture Example")


